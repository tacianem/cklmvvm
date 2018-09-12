package com.example.tacianemartimiano.cklmvvm.modules.articlesorting

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import kotlinx.android.synthetic.main.article_sorting.*

class ArticleSortingActivity : BaseActivity() {

    private var viewModel: ArticleSortingViewModel? = null

    private var readMarked = true
    private var unreadMarked = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.article_sorting)
        viewModel = ViewModelProviders.of(this).get(ArticleSortingViewModel::class.java)

        setupView()

        sortReadCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                readMarked = true
            } else {
                if (!sortUnreadCheckbox.isChecked) {
                    sortReadCheckbox.isChecked = true
                    readMarked = true
                } else {
                    readMarked = false
                }
            }
        }

        sortUnreadCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                unreadMarked = true
            } else {
                if (!sortReadCheckbox.isChecked) {
                    sortUnreadCheckbox.isChecked = true
                    unreadMarked = true
                } else {
                    unreadMarked = false
                }
            }
        }
    }

    private fun setupView() {
        showBackButton()
    }

    fun onClickSort(view: View) {
        viewModel?.onSortClicked(this, (view as TextView).text, readMarked, unreadMarked)
    }

}