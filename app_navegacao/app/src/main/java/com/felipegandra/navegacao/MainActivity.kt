package com.felipegandra.navegacao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.felipegandra.navegacao.screens.LoginScreen
import com.felipegandra.navegacao.screens.MenuScreen
import com.felipegandra.navegacao.screens.PedidosScreen
import com.felipegandra.navegacao.screens.PerfilScreen
import com.felipegandra.navegacao.ui.theme.NavegaçãoTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegaçãoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, tween(1500)) +
                                    fadeOut(animationSpec = tween(1500))
                        },
                        enterTransition = {
                            slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Up, tween(1500))
                        }
                    ){
                        composable(route = "login"){ LoginScreen(navController) }
                        composable(route = "menu") { MenuScreen(navController) }

                        composable(
                            route = "pedidos?numero={numero}",
                            arguments = listOf(navArgument(name = "numero"){
                                defaultValue = "sem valor"
                            })
                        ){ PedidosScreen(navController, it.arguments?.getString("numero")!!) }


                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument(name = "nome"){
                                    type = NavType.StringType
                                },
                                navArgument(name = "idade"){
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            //val nome = it.arguments?.getString("nome")
                            val nome = it.arguments?.getString("nome")
                            val idade = it.arguments?.getInt("idade")

                            PerfilScreen(navController, nome!!, idade!!)
                        }
                    }
                }
            }
        }
    }
}