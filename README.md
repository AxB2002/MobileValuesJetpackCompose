# MobileValuesJetpackCompose

Welcome to MobileValuesJetpackCompose! This mobile app development project combines Jetpack Compose with a foundational set of core values. Explore its features, technologies, and learn how to contribute.

## Overview

JetComposeValuesApp is a cutting-edge mobile app development project that leverages the power of Jetpack Compose. With a subtle integration of core values, the app offers a unique and meaningful user experience. Dive into its features and explore its utility through concise descriptions and visual representations.

## Features

Explore key features, such as:
- **Value-Driven UI:** Immerse users in a UI design that reflects core values for a more meaningful interaction.
- **Dynamic Compose Elements:** Leverage Jetpack Compose for creating dynamic and interactive UI components.
- **Effortless Navigation:** Seamless navigation through the app, ensuring a smooth user journey.

## Technologies Used

Get acquainted with the technologies employed, including:
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [ViewModel for Architecture](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=fr)
- [Kotlin Coroutines for Asynchronous Programming](https://kotlinlang.org/docs/async-programming.html)

## Installation

1. Clone the repository: `https://github.com/AxB2002/MobileValuesJetpackCompose.git`
2. Navigate to the project directory.

## Configuration

Understand any necessary configurations, such as API keys or specific files, to ensure seamless project functionality.

## Usage

Learn how to use the application with provided examples and code snippets.

```kotlin
// Example code
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var addCourseDialog by rememberSaveable {
        mutableStateOf(false)
    }
    val courses  by rememberSaveable {
        mutableStateOf(
            mutableListOf<Course>(
                Course("420-PPA-ID", "Profession programmer analyst", 60),
                Course("420-ARP-ID", "Structured Approach to Problem Solving", 60),
                Course("420-PWD-ID", "Web Programmation", 60),
            )
        )
    }
