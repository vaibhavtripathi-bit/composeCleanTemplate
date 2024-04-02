package com.example.composecleanarchitecture.di

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composecleanarchitecture.presentation.navigation.CANavigation
import com.example.composecleanarchitecture.presentation.navigation.CANavigationImpl
import com.example.composecleanarchitecture.presentation.theme.LocalAppNavControllerProvider
import org.koin.dsl.module

val navigationDependency = module {
    factory<NavController> { (navController: NavHostController) -> navController }
    single<CANavigation> { CANavigationImpl() }

}
