<h1 align="center">Task Prioritization App with Jetpack Compose</h1>

## Overview

The Task Prioritization App is a modern Android application built using Jetpack Compose and MVVM architecture, adhering to Google's latest design guidelines and best practices.

## Features

### Home Page

- The home page displays all your tasks in a list using `LazyColumn`, providing a smooth and efficient user experience.
- Each task has a `RadioButton` that allows you to mark it as completed, visually improving task management.

### Add Task Popup

- Easily add new tasks by tapping the floating action button (FAB) located at the bottom right corner of the screen.
- A user-friendly `AlertDialog` prompts you to input task details and seamlessly updates the database.
- We utilize `MutableState` to ensure the UI recomposes whenever data changes, providing real-time updates.

### Delete Task Popup

- Delete tasks with a long-press gesture on any task item, making it quick and intuitive.
- A red delete button appears upon long-press, initiating an `AlertDialog` for confirmation before deletion.

## Screenshots

<p align="center">
<img src = "https://github.com/Suryanshu-rana/TodoApp/assets/61387349/ca4a9aba-7e5c-4069-8449-a2928df6eaa8" width ="244" height ="456">
<img src= "https://github.com/Suryanshu-rana/TodoApp/assets/61387349/d493ba11-7e78-4780-9e21-0d3ce2df871f" widht = "244" height ="456">
<img src = "https://github.com/Suryanshu-rana/TodoApp/assets/61387349/21926adb-8bd0-4a92-a3eb-0137900968a1" width = "244" height ="456">
<img src = "https://github.com/Suryanshu-rana/TodoApp/assets/61387349/5da62335-bc7e-4093-99b5-4a11aa5d8136" width = "244" height ="456">
</p>

## Technology Stack

- **Jetpack Compose**: A modern Android UI toolkit that simplifies UI development.
- **MVVM Architecture**: Ensures a clean and maintainable codebase by separating concerns.
- **Room Database**: Used for efficient data storage and retrieval.
- **Material Design**: Adheres to Google's design guidelines for a polished and consistent user interface.

## Getting Started

To get started with the Task Prioritization App, follow these steps:

1. **Clone the repository:**

   ```sh
   git clone https://github.com/Suryanshu-rana/TodoApp.git

2. **Open the project in Android Studio.**

3. **Build and run the app on an Android emulator or device.**

## Usage

- Create tasks by tapping the "Add" button.
- Assign priorities to tasks to organize them effectively.
- Edit or delete tasks as needed.
- Enjoy an efficient task management experience!

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.
   ```sh
   git checkout -b feature/my-feature

4. Make your changes and commit them.
   ```sh
   git commit -m "Add my feature"

6. Push your changes to your fork.
   ```sh
   git push origin feature/my-feature

8. Open a pull request to the main repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or suggestions, feel free to contact us at SuryanshuInnovates@gmail.com.

Happy task prioritization!
 

