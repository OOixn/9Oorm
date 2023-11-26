const toDoForm = document.getElementById("todo-form");
const toDoInput = document.querySelector("#todo-form input");
const toDoList = document.getElementById("todo-list");
const toDos_key = "toDos";
let toDos = [];

function saveToDos() {
  localStorage.setItem(toDos_key, JSON.stringify(toDos));
}

function deleteTodo(event) {
  const li = event.target.parentElement;
  toDos = toDos.filter((toDo) => toDo.id !== parseInt(li.id));
  saveToDos();
  li.remove();
}

function checkTodo(event) {
  const li = event.target.parentElement;
  li.classList.toggle("checked");
  toDos = toDos.filter((toDo) => toDo.id !== parseInt(li.id));
  saveToDos();
}

function changeTodo(event) {
  const span = event.target.previousSibling;
  const inputField = document.createElement("input");
  inputField.type = "text";
  inputField.value = span.innerText;
  inputField.onblur = function () {
    span.innerText = inputField.value;
    span.style.display = "";
    inputField.remove();
  };
  span.parentElement.insertBefore(inputField, span);
  span.style.display = "none";
  inputField.focus();
}

function createTodo(todo) {
  const li = document.createElement("li");
  li.id = todo.id;
  const span = document.createElement("span");
  span.innerText = todo.text;
  const delBtn = document.createElement("button");
  delBtn.innerText = "X";
  const changeBtn = document.createElement("button");
  changeBtn.innerText = "수정";
  const checkBtn = document.createElement("button");
  checkBtn.innerText = "✔";
  li.appendChild(span);
  li.appendChild(changeBtn);
  li.appendChild(checkBtn);
  li.appendChild(delBtn);
  toDoList.appendChild(li);
  delBtn.addEventListener("click", deleteTodo);
  changeBtn.addEventListener("click", changeTodo);
  checkBtn.addEventListener("click", checkTodo);
}

function handleSubmit(event) {
  event.preventDefault();
  const newTodo = toDoInput.value;
  toDoInput.value = "";
  const newTodos = {
    text: newTodo,
    id: Date.now(),
  };
  toDos.push(newTodos);
  createTodo(newTodos);
  saveToDos();
}

toDoForm.addEventListener("submit", handleSubmit);

function loadToDos() {
  const savedToDos = localStorage.getItem(toDos_key);
  if (savedToDos) {
    const parsedToDos = JSON.parse(savedToDos);
    parsedToDos.forEach(createTodo);
  }
}

loadToDos();

// 시계
const clock = document.getElementById("clock");

function getClock() {
  const date = new Date();
  const hours = String(date.getHours()).padStart(2, "0");
  const minutes = String(date.getMinutes()).padStart(2, "0");
  const seconds = String(date.getSeconds()).padStart(2, "0");
  clock.innerText = `${hours}:${minutes}:${seconds}`;
}

setInterval(getClock, 1000);
