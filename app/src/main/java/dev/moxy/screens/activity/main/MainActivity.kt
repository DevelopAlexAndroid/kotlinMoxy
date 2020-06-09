package dev.moxy.screens.activity.main

import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import dev.moxy.App.Companion.TAG
import dev.moxy.R
import dev.moxy.repository.model.mNote
import dev.moxy.screens.fragment.addedWord.AddedWordFragment
import dev.moxy.screens.fragment.dictionary.DictionaryFragment
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

    private var flag = false
    private val addedWordFragment = AddedWordFragment()
    private val dictionaryFragment = DictionaryFragment()

    private val navigator: Navigator =
        object : SupportAppNavigator(this, supportFragmentManager, R.id.container) {

            override fun setupFragmentTransaction(
                command: Command,
                currentFragment: androidx.fragment.app.Fragment?,
                nextFragment: androidx.fragment.app.Fragment?,
                fragmentTransaction: androidx.fragment.app.FragmentTransaction
            ) {
                super.setupFragmentTransaction(
                    command,
                    currentFragment,
                    nextFragment,
                    fragmentTransaction
                )
            }
        }
    // { @Override protected Fragment
    // createFragment(String screenKey, Object data) {
    // (screenKey) { case LIST_SCREEN: return ListFragment.getNewInstance(data);
    // case DETAILS_SCREEN:
    // DetailsFragment.getNewInstance(data);
    // default: throw new RuntimeException(“Unknown screen key!”); } }
    // @Override protected void showSystemMessage(String message) {
    // Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show(); }
    // @Override protected void exit() { finish(); } };
    // @Override protected void onResume() { super.onResume();
    // SampleApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator); }
    // @Override protected void onPause() { super.onPause();
    // SampleApplication.INSTANCE.getNavigatorHolder().removeNavigator(); }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
            transaction.replace(R.id.container, addedWordFragment)
        else
            transaction.replace(R.id.container, dictionaryFragment)
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
            var mNote = mNote(head = "1321", text = "123132")
            mainPresenter.addNote(mNote)
        }.start()

    }

    override fun print() {
        Log.d(TAG, "PRINT")
    }
}
