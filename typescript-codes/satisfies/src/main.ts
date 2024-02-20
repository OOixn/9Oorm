type Colors = "red" | "green" | "blue";

type RGB = [red: number, green: number, blue: number];

const palette = {
  red: [255, 0, 0],
  green: "#00ff00",
  blue: [0, 0, 255],
} satisfies Record<Colors, string | RGB>;

const redComponent = palette.red.at(0);

const greenNormalized = palette.green.toUpperCase();
// satisfies 없이 레코드로 타입을 지정해주려고 하면 오류가 난다.
// 왜? green은 string | rgb 을 받아오고 rgb 타입은 숫자이기때문에 toUpperCase를 사용할 수 없다.
