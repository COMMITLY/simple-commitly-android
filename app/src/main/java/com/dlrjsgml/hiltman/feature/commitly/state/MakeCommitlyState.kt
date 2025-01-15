package com.dlrjsgml.hiltman.feature.commitly.state

data class MakeCommitlyState(
    val data: CommitlyInfo? = null,
    val isLoading: Boolean = false,
)

data class CommitlyInfo(
    val gptResponse: String
)