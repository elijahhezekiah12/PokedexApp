# Pokédex App

# Project Overview
This application fetches and displays data from the [PokeAPI](https://pokeapi.co), showcasing modern Android development practices with a focus on clean architecture, modularization, and reactive programming.

## Architecture

The app follows the **Model-View-ViewModel (MVVM)** pattern and adheres to **Clean Architecture** principles. The codebase is organized into three primary layers:

- **Presentation**: Handles UI logic and interacts with ViewModels.
- **Domain**: Contains business logic, use cases, and interfaces.
- **Data**: Responsible for retrieving data from remote sources and implementing repositories.

Each layer is separated into distinct packages to ensure **separation of concerns**, **modularity**, and **maintainability**.

##  Key Technologies

- **Kotlin Coroutines & Flow**: For asynchronous data handling and reactive streams.
- **Hilt**: Used for dependency injection to decouple components and improve testability.
- **Retrofit**: Handles HTTP requests to the PokeAPI.
- **MVVM + Clean Architecture**: Ensures a scalable, testable, and maintainable code structure.

##  Data Flow

1. The `Repository` retrieves data from the PokeAPI.
2. A `UseCase` consumes this data via a Kotlin `Flow`, enabling thread-safe and reactive data handling.
3. The `ViewModel` collects and processes this flow, updating the UI accordingly through  `StateFlow`.

Using a `Flow` in the domain layer enables:
- Efficient streaming and transformation of data.
- Clear separation between business logic and data sources.
- Thread-safe and lifecycle-aware data handling.

##  Design Principles

This project is built with the **SOLID principles** in mind:

- **Single Responsibility Principle**: Each class has a clearly defined responsibility.
- **Open/Closed Principle**: Components are open for extension, closed for modification.
- **Liskov Substitution Principle**: Interfaces and abstractions are respected.
- **Interface Segregation Principle**: Interfaces are client-specific and minimal.
- **Dependency Inversion Principle**: High-level modules depend on abstractions, not concrete implementations.

These principles, combined with dependency injection via Hilt, ensure a loosely coupled, highly testable codebase.


##  Limitations & Future Improvements

While the core features and architecture are in place, there are areas that could be improved with more time and resources:

###  Missing Features

- **UI Testing**: Due to time constraints, comprehensive UI tests were not implemented. Future updates should include UI test coverage using tools like Espresso or Jetpack Compose Test APIs to ensure interface reliability.

###  Modularity Enhancements

- While the application follows clean architecture, it could benefit from deeper **modularization**:
    - Each screen or feature could be separated into its own **Gradle module** (e.g., `feature-list`, `feature-details`, etc.).
    - This would improve **scalability**, **build performance**, and **team collaboration**, and align better with large-scale Android development practices.
    - These modules would then be consumed by a higher-level `app` module, following the **repository pattern** and **dependency inversion** principles.

###  API Data Handling

- The PokeAPI contains numerous **nullable fields**, which introduces complexity in data parsing.
    - A more robust `data class` structure should be created to safely handle potential null values from the API.
    - Consider using default values, safe-call operators, or custom deserializers to ensure stability and data integrity.

---