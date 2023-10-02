//Component for displaying individual tasks.
import React from 'react';

const TaskItem = ({ task, onDelete, onToggle }) => {
  return (
    <div className={`task ${task.completed ? 'completed' : ''}`}>
      <h3>
        {task.title}{' '}
        <button className="delete-btn" onClick={() => onDelete(task.id)}>
          Delete
        </button>
      </h3>
      <p>{task.description}</p>
      <p>Due Date: {task.dueDate}</p>
      <input
        type="checkbox"
        checked={task.completed}
        onChange={() => onToggle(task.id)}
      />{' '}
      Completed
    </div>
  );
};

export default TaskItem;