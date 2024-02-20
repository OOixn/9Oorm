// document.addEventListener('click', (event) => {})

// document.addEventListener('keypress', (event) => {})

interface MyMouseEvent {
  x: number;
  y: number;
}

interface MyKeyboardEvent {
  key: string;
}

interface MyEventObjects {
  click: MyMouseEvent;
  keypress: MyKeyboardEvent;
}

function handleEvent<K extends keyof MyEventObjects>(
  eventName: K,
  callback: (e: MyEventObjects[keyof MyEventObjects]) => void
) {
  if (eventName === "click") {
    callback({ x: 1, y: 2 });
  } else if (eventName === "keypress") {
    callback({ key: "Enter" });
  }
}

handleEvent("click", (e) => {});
