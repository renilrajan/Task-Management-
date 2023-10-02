import React, { useState, useEffect } from 'react';
import './App.css';
import TaskList from './components/TaskList';
import TaskForm from './components/TaskForm';

function App() {
  const [tasks, setTasks] = useState([]);

  // Fetch tasks from the backend (replace with your API endpoint)
  useEffect(() => {
    // Fetch tasks from the backend and update the 'tasks' state
    // Example:
    // fetch('/api/tasks')
    //   .then((response) => response.json())
    //   .then((data) => setTasks(data));
  }, []);

  // Add a new task
  const addTask = (task) => {
    // Add the new task to the backend and update the 'tasks' state
    // Example:
    // fetch('/api/tasks', {
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json',
    //   },
    //   body: JSON.stringify(task),
    // })
    //   .then((response) => response.json())
    //   .then((data) => setTasks([...tasks, data]));
  };

  // Delete a task
  const deleteTask = (id) => {
    // Delete the task from the backend and update the 'tasks' state
    // Example:
    // fetch(`/api/tasks/${id}`, {
    //   method: 'DELETE',
    // })
    //   .then(() => setTasks(tasks.filter((task) => task.id !== id)));
  };

  // Toggle task completion status
  const toggleCompletion = (id) => {
    // Update the task's completion status on the backend and update the 'tasks' state
    // Example:
    // fetch(`/api/tasks/${id}`, {
    //   method: 'PUT',
    //   headers: {
    //     'Content-Type': 'application/json',
    //   },
    //   body: JSON.stringify({ completed: !tasks.find((task) => task.id === id).completed }),
    // })
    //   .then((response) => response.json())
    //   .then((data) => {
    //     setTasks(
    //       tasks.map((task) =>
    //         task.id === id ? { ...task, completed: data.completed } : task
    //       )
    //     );
    //   });
  };

  return (
    <div className="container">
      <header>
        <h1>Task Manager</h1>
      </header>
      <TaskForm onAdd={addTask} />
      {tasks.length > 0 ? (
        <TaskList tasks={tasks} onDelete={deleteTask} onToggle={toggleCompletion} />
      ) : (
        <p>No tasks available.</p>
      )}
    </div>
  );
}

export default App;
