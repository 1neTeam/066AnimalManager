package com.lion.a066_ex_animalmanager.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lion.a061ex_roomdatabase.repository.AnimalRepository
import com.lion.a066_ex_animalmanager.MainActivity
import com.lion.a066_ex_animalmanager.R
import com.lion.a066_ex_animalmanager.databinding.FragmentModifyBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

// 동물 정보 수정 화면
class ModifyFragment : Fragment() {

    lateinit var fragmentModifyBinding: FragmentModifyBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentModifyBinding = FragmentModifyBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        // 툴바 설정 메서드 호출
        settingToolbar()

        return fragmentModifyBinding.root
    }

    // Toolbar 설정 메서드
    fun settingToolbar() {
        fragmentModifyBinding.apply {
            toolbarModify.title = "동물 정보 수정"
            // 뒤로 가기 (네비게이션)
            toolbarModify.setNavigationIcon(R.drawable.arrow_back_24px)
            toolbarModify.setNavigationOnClickListener {
                mainActivity.removeFragment(FragmentName.MODIFY_FRAGMENT)
            }
            // 메뉴
            toolbarModify.inflateMenu(R.menu.toolbar_menu_modify_fragment)
            toolbarModify.setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.modify_toolbar_menu_done -> {
                        mainActivity.removeFragment(FragmentName.MODIFY_FRAGMENT)
                    }
                }
                true
            }
        }
    }

    // 입력 요소들 초기 설정
    fun settingInput() {
        fragmentModifyBinding.apply {
            // 동물 번호를 가져온다.
            val animalIdx = arguments?.getInt("animalIdx")!!
            // 동물 데이터를 가져온다.
            CoroutineScope(Dispatchers.Main).launch {
                val work1 = async(Dispatchers.IO) {
                    AnimalRepository
                }
            }
        }
    }

}