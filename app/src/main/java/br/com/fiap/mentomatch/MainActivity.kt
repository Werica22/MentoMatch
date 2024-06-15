package br.com.fiap.mentomatch

import android.Manifest
import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentomatch.components.DesignTelas
import br.com.fiap.mentomatch.ui.theme.MentoMatchTheme
import br.com.fiap.mentomatch.uiscreens.CadastroPerfilScreen
import br.com.fiap.mentomatch.uiscreens.CadastroScreen
import br.com.fiap.mentomatch.uiscreens.CalendarioScreen
import br.com.fiap.mentomatch.uiscreens.EntrarPerfilScreen
import br.com.fiap.mentomatch.uiscreens.LoginGoogleScreen
import br.com.fiap.mentomatch.uiscreens.LoginScreen
import br.com.fiap.mentomatch.uiscreens.MatchScreen
import br.com.fiap.mentomatch.uiscreens.MentorCadastro
import br.com.fiap.mentomatch.uiscreens.MentoradoCadastro
import br.com.fiap.mentomatch.uiscreens.PerfilMentorScreen
import br.com.fiap.mentomatch.uiscreens.PerfilMentoradoScreen

import br.com.fiap.mentomatch.uiscreens.RedefinirSenhaScreen


class MainActivity : ComponentActivity() {
    val CHANNEL_ID = "meu_canal"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationChannel()

        var openOfNotification = false;

        val action = intent.action
        if(action == "ACTION_NOTIFY_MATCH") {
            openOfNotification = true
        } else {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                runNotify()
                // cancelar loop depois
                handler.removeCallbacksAndMessages(null)
            }, 120000)
        }

        setContent {
            MentoMatchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    DesignTelas {
                        var startDestination = "login"

                        if (openOfNotification) {
                            startDestination = "match"
                        }

                        val navController = rememberNavController()
                        NavHost(navController = navController,
                            startDestination = startDestination,
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.End,
                                    tween(1000)
                                ) + fadeOut(animationSpec = tween(1000))
                            },
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                                    tween(500)
                                )
                            }) {

                            composable(route = "login") {
                                LoginScreen(navController)
                            }
                            composable(route = "cadastro") {
                                CadastroScreen(navController)
                            }
                            composable(route = "cadastroPerfil") {
                                CadastroPerfilScreen(navController)
                            }
                            composable(route = "entrarPerfil") {
                                EntrarPerfilScreen(navController)
                            }
                            composable(route = "mentor") {
                                MentorCadastro(navController)
                            }
                            composable(route = "mentorado") {
                                MentoradoCadastro(navController)
                            }
                            composable(route = "loginGoogle") {
                                LoginGoogleScreen(navController)
                            }
                            composable(route = "esqueciSenha") {
                                RedefinirSenhaScreen(navController)
                            }
                            composable(route = "perfilMentorado") {
                                PerfilMentoradoScreen(navController)
                            }
                            composable(route = "perfilMentor") {
                                PerfilMentorScreen(navController)
                            }
                            composable(route = "calendario") {
                                CalendarioScreen(navController)
                            }
                            composable(route = "match") {
                                MatchScreen(navController)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun createNotificationChannel() {
        // Create the notification channel is needed from O OS.
        val name = "channel_name"
        val descriptionText = "description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        // Register the channel with the system.
        val notificationManager:NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun runNotify() {
        val intent = Intent(this, MainActivity::class.java).apply {
            action = "ACTION_NOTIFY_MATCH"
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.logomm)
            .setContentTitle("Encontramos um mentor/mentorado para você")
            .setContentText("Clique aqui para ver quem combina com você")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(0,builder.build())
        }
    }
}





