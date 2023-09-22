# TaskPrioritization App with Jetpack COMPOSE
Task Prioritization App using Jetpack compose and MVVM using the latest design techniqe and best prectice adviced by google .

## App Overview 
<img src = "https://github.com/Suryanshu-rana/TodoApp/assets/61387349/ca4a9aba-7e5c-4069-8449-a2928df6eaa8" width ="244" height ="456">
<img src= "https://github.com/Suryanshu-rana/TodoApp/assets/61387349/d493ba11-7e78-4780-9e21-0d3ce2df871f" widht = "244" height ="456">
<img src = "https://github.com/Suryanshu-rana/TodoApp/assets/61387349/21926adb-8bd0-4a92-a3eb-0137900968a1" width = "244" height ="456">
<img src = "https://github.com/Suryanshu-rana/TodoApp/assets/61387349/5da62335-bc7e-4093-99b5-4a11aa5d8136" width = "244" height ="456">

## Compose
Jetpack Compose has been used for the designing of the application.
### Feature
This is a simple task App with following functionalities
* #### Home page
  * The home page consists of all the todos in a list we have used `LazyColumn` to create a list( It works as an alternative of recycler view in compose ).
  * The list have a `RadioButton` that marks the task as completed by cutting it
* #### Add Popup
  * The add functionality shon by a button in the bottom right of the screen which opens a `AlertDialogue` that askes for the input and upates it in database.
  * We have used `mutablestate` variable to store the data so that UI sould recompose everytime the data is updated.
* #### Delete Popup
  * The delete functionality enable when you long press on any of the `Task` and gets hidden when you hold the task again.
  * A red color delete button appears which asks for a `AlertDialogue` when you delete any item and deletes it when you proceed with confirmation.
