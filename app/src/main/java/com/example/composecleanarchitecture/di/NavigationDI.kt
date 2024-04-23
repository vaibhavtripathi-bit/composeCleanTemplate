package com.example.composecleanarchitecture.di

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composecleanarchitecture.presentation.navigation.CANavigation
import com.example.composecleanarchitecture.presentation.navigation.CANavigationImpl
import com.example.composecleanarchitecture.presentation.theme.LocalAppNavControllerProvider
import org.koin.core.qualifier.named
import org.koin.dsl.module

val navigationDependency = module {
    single<CANavigation> { CANavigationImpl() }
    single<CANavigation>(named("HomeTab")) { CANavigationImpl() }
    single<CANavigation>(named("DetailTab")) { CANavigationImpl() }
    single<CANavigation>(named("SettingTab")) { CANavigationImpl() }
}
