package ru.potemkin.pumpumprototype.navigation

sealed class Screen(
    val route: String
) {

    object LearningHome : Screen(ROUTE_LEARNING_HOME)
    object Learning : Screen(ROUTE_LEARNING)
    object TopicHome : Screen(ROUTE_TOPIC_HOME)
    object Topic : Screen(ROUTE_TOPIC)
    object Theory : Screen(ROUTE_THEORY)
    object Exercise : Screen(ROUTE_EXERCISE)
    object Results : Screen(ROUTE_RESULTS)
    object Auth : Screen(ROUTE_AUTH)
    object Rating : Screen(ROUTE_RATING)
    object Profile : Screen(ROUTE_PROFILE)

    private companion object {

        const val ROUTE_LEARNING_HOME = "learning home"
        const val ROUTE_LEARNING = "learning"
        const val ROUTE_TOPIC_HOME = "topic home"
        const val ROUTE_TOPIC = "topic"
        const val ROUTE_THEORY = "theory"
        const val ROUTE_EXERCISE = "exercise"
        const val ROUTE_RESULTS = "results"
        const val ROUTE_AUTH = "authentication"
        const val ROUTE_RATING = "rating"
        const val ROUTE_PROFILE = "rating"
    }
}