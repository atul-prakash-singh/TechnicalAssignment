# TechnicalAssignment

```
[Technical Assignment]
```
This application consumes NY TIMES Public api and displays all most popular news articles, user see details by clicking on respective news articles.

# Screenshots

## NYT Most Popular Article Master Screen

<img src="https://github.com/atul-prakash-singh/TechnicalAssignment/blob/master/screenshot/screen_article_master.png" width="250"/>

## NYT Most Popular Article Detail Screen

<img src="https://github.com/atul-prakash-singh/TechnicalAssignment/blob/master/screenshot/screen_article_detail.png" width="250"/>

## Overall Application Design

* MVVM along with DataBinding
* Android Architecture Components : LiveData, ViewModel, Room Persistence Storage & Paging Library
* This entire assignment is developed in pure Kotlin.
* Used Kotlin Coroutines for background tasks management.

## Built With

* [Kotlin](https://kotlinlang.org/) - Official Android Language
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/) - Lifecycle aware components (uses Room, ViewModel, LiveData & Paging Library)
* [KOIN](https://insert-koin.io/) - Dependency Injection Framework for Kotlin
* [Retrofit2](http://square.github.io/retrofit/) - Used to fetch articles from NY TIMES's Most Popular public api
* [Glide](https://github.com/bumptech/glide/) - Used for article image downloading and caching
* [Kakao](https://github.com/agoda-com/Kakao) - DSL for Espresso Tests

### Static Code Analysis

Detekt(https://github.com/arturbosch/detekt)

If trying from command line :
```
./gradlew detekt
./gradlew lint
```

### Prerequisites
```
Android Studio 3.3
```

### Installing

Since this is normal android application, after cloning this project in Android Studio it can be run using "Run" button.

If trying from command line :
```
./gradlew assembleDebug
./gradlew installDebug
```

### Graphic Assets
* [icons8](https://icons8.com/) - Used for image icons

## Running the tests
* Jacoco(https://www.jacoco.org/jacoco/) - Tests Code Coverage
```
./gradlew clean jacocoTestReport
```

### Unit Test
* Added JUnit Test suits for ViewModels & Repository
```
JUnit
Mockito
MockRetrofit
KoinTest
```

### Integration & UI Test
* Added Espresso Test suits of both Master & Detail Most Popular Article Screens
```
Espresso
Kakao
UIAutomator
KoinTest
Mockito
```