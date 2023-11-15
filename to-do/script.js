const toDoForm = document.getElementById("todo-form");
const toDoInput = document.querySelector("#todo-form input");
const toDoList = document.getElementById("todo-list");

const toDos = [];

function deleteTodo(event) {
  const li = event.target.parentElement;
  li.remove();
}

function checkTodo(event) {
  const li = event.target.parentElement;
  li.classList.toggle("checked");
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

function handleSubmit(event) {
  event.preventDefault();
  const newTodo = toDoInput.value;
  toDoInput.value = "";
  const li = document.createElement("li");
  const span = document.createElement("span");
  span.innerText = newTodo;
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

toDoForm.addEventListener("submit", handleSubmit);

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
