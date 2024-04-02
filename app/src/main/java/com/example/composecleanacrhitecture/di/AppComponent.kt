package com.example.composecleanacrhitecture.di

/**
 * Root DI component with list of multiple dependencies.
 */

val appComponent = listOf(
    repositoryDependency,
    useCases,
    viewModelDependency,
    networkDependency,
    storageDependency,
    navigationDependency
)
