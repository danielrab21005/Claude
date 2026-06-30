package com.nrs.tapforward.ui.members

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrs.tapforward.data.model.Member
import com.nrs.tapforward.data.repository.MemberRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MembersViewModel @Inject constructor(private val repository: MemberRepository) : ViewModel() {

    private val query = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val members: Flow<List<Member>> = query.flatMapLatest { q ->
        if (q.isBlank()) repository.getAllActiveMembers()
        else repository.searchMembers(q)
    }

    fun search(q: String) { query.value = q }

    fun addMember(firstName: String, lastName: String, email: String, phone: String) {
        viewModelScope.launch {
            repository.save(Member(firstName = firstName, lastName = lastName, email = email, phone = phone))
        }
    }
}
