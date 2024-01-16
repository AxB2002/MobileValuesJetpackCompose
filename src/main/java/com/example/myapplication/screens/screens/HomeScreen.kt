package com.example.myapplication.screens.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.model.Course

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


    if(addCourseDialog){
        AddCourseDialog(title = "Add Course",
            onConfirm = {
                courses.add(it)
                addCourseDialog = false
            },
            onDismiss = {
                addCourseDialog = false
            })
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { addCourseDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add a Record")
            }
        }
    ) {
        Box(modifier = modifier.padding(it)) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                DataLists(
                    course = courses
                )
            }
        }
    }

}

@Composable
fun DataLists(
    course: List<Course>,
) {
    Text(text = "List of Courses", Modifier.padding(10.dp))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 6.dp)
    ) {
        LazyColumn {
            items(course.size) { index ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(top = 6.dp)
                        .background(MaterialTheme.colorScheme.secondary)

                ) {
                    Column(
                        Modifier.padding(start = 6.dp)
                    ) {
                        Text(
                            text = "Id              ${course[index].courseCode}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(),
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                        Text(
                            text = "Name      ${course[index].courseName}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(),
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                        Text(
                            text = "Duration  ${course[index].courseDuration} Hours",
                            textAlign = TextAlign.Center,
                            style = TextStyle(),
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    }


                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCourseDialog(
    title: String,
    onConfirm: (Course) -> Unit,
    onDismiss: () -> Unit,
    confirmText: String = "Confirm",
    dismissText: String = "Dismiss"
) {
    var courseName by rememberSaveable {
        mutableStateOf("")
    }
    var courseCode by rememberSaveable {
        mutableStateOf("")
    }
    var courseDuration by rememberSaveable {
        mutableStateOf(0)
    }
    val focusManager = LocalFocusManager.current

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = title) },
        text = {
            Column {
                Text(text = "Course Code")
                OutlinedTextField(
                    value = courseCode,
                    onValueChange = {
                        courseCode = it
                })
                Text(text = "Course Name")
                        OutlinedTextField(value = courseName, onValueChange = {
                    courseName = it
                })
                Text(text = "Course Duration")
                OutlinedTextField(value = courseDuration.toString(), onValueChange = {
                    courseDuration = if(it.toIntOrNull() == null) 0 else it.toInt()
                }
               )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm( Course(courseCode, courseName, courseDuration))
                }
            ) {
                Text(text = confirmText)
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(text = dismissText)
            }
        }
    )
}