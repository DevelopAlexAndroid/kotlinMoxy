package dev.moxy.screens.activity.main

import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import dev.moxy.App.Companion.TAG
import dev.moxy.repository.model.mNote
import dev.moxy.screens.fragment.addedWord.AddedWordFragment
import dev.moxy.screens.fragment.dictionary.DictionaryFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : MvpAppCompatActivity(), MainView {
    //приложение словарь слов для запоминания. (фрагмент)Экран 1 список слов при клике на элемент(слово) появляется перевод
//(фрагмент)2 экран добавление/удаление слов список слов с кнопкой добавить свайп на удаление и редактирование
//основной экран содержит кнопку перехода на другую активити с webView переводчиком, и фрагменты (анимации)
    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun provideDetailsPresenter(): MainPresenter {
        return MainPresenter("it's const in activity")
    }

    private var flag = false
    private val addedWordFragment = AddedWordFragment()
    private val dictionaryFragment = DictionaryFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dev.moxy.R.layout.activity_main)

        mainPresenter.print()

        button.setOnClickListener {
            swipeFragment(flag)
        }

        button2.setOnClickListener {
            addNote()
        }
    }

    fun swipeFragment(flag: Boolean) {
        this.flag = !flag
        val manager = supportFragmentManager

        // Begin the fragment transition using support fragment manager
        val transaction = manager.beginTransaction()

        // Replace the fragment on container
        if (flag)
            transaction.replace(dev.moxy.R.id.container, addedWordFragment)
        else
            transaction.replace(dev.moxy.R.id.container, dictionaryFragment)
        transaction.addToBackStack(null)

        // Finishing the transition
        transaction.commit()


       /* Thread {

            var s = mainPresenter.getList()
            Log.d(TAG, s[0].head)
        }.start()*/

    }

    fun addNote() {
        Thread {
            var mNote = mNote( head = "1321", text =  "123132")
            mainPresenter.addNote(mNote)
        }.start()

    }

    override fun print() {
        Log.d(TAG, "PRINT")
    }
}
