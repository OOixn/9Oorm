import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { applyMiddleware, createStore } from "redux";
import rootReducer from "./reducers";
import { Provider } from "react-redux";
import { thunk } from "redux-thunk";
const root = ReactDOM.createRoot(document.getElementById("root") as HTMLElement);

const loggerMiddleware = (store: any) => (next: any) => (action: any) => {
  console.log("store", store);
  console.log("action", action);
  next(action); // 다음 껄로 넘겨준다? 미들웨어에서 리듀서로 넘겨준단 뜻인가? 미들웨어를 여러개 만들 수 있다. 미들웨서 -> 미들웨어로 갈 수도 있고 마지막 미들웨어면, 리듀서로 가는 것이다.
};

const middleware = applyMiddleware(thunk, loggerMiddleware); // 버전 때문에 생기는 오류.
const store = createStore(rootReducer); // 스토어 생성할 때 미들웨어도 등록.

// 프로바이더가 모든 컴포넌트한테 리덕스 스토어를 제공해준다고 생각하면 된다.
const render = () =>
  root.render(
    <React.StrictMode>
      <Provider store={store}>
        <App
          value={store.getState()}
          onIncrement={() => store.dispatch({ type: "INCREMENT" })}
          onDecrement={() => store.dispatch({ type: "DECREMENT" })}
        />
      </Provider>
    </React.StrictMode>
  );
render();

store.subscribe(render);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
