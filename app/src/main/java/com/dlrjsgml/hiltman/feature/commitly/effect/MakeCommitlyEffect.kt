package com.dlrjsgml.hiltman.feature.commitly.effect

sealed interface MakeCommitlyEffect {
    data object Success: MakeCommitlyEffect
    data object Failed: MakeCommitlyEffect
}