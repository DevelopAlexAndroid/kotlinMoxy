package dev.moxy.screens.activity.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import dev.moxy.App
import dev.moxy.R
import dev.moxy.repository.model.mNote
import dev.moxy.screens.activity.OnBackPressed
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command


class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {
    //приложение словарь слов для запоминания. (фрагмент)Экран 1 список слов при клике на элемент(слово) появляется перевод
//(фрагмент)2 экран добавление/удаление слов список слов с кнопкой добавить свайп на удаление и редактирование
//основной экран содержит кнопку перехода на другую активити с webView переводчиком, и фрагменты (анимации)
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return MainPresenter("it's const in activity")
    }

    private val navigator: Navigator =
        object : SupportAppNavigator(this, supportFragmentManager, R.id.container) {
            override fun setupFragmentTransaction(
                command: Command,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction
            ) {
                // Fix incorrect order lifecycle callback of MainFragment
                fragmentTransaction.setReorderingAllowed(true)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        add_note.setOnClickListener {
            addNote()
        }
        info_app.setOnClickListener {
            mainPresenter.navigateToInfo()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val focusFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.container)

        if (supportFragmentManager.backStackEntryCount > 1
            && focusFragment != null
            && focusFragment.isAdded
            && focusFragment is OnBackPressed
        ) {
            (focusFragment as OnBackPressed).onBackPressed()
        } else {
            this.finish()
        }
    }

    private fun addNote() {
        Thread {
            val mNote = mNote(text = "тест", translate = "text")
            mainPresenter.addNote(mNote)
        }.start()
    }

}
