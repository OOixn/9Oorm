const headerBg = document.querySelector(".main_header");

window.addEventListener("scroll", function () {
  if (window.scrollY >= 200) {
    headerBg.style.backgroundColor = "#111";
  } else {
    headerBg.style.backgroundColor = "transparent";
  }
});

const prev1 = document.querySelector(".swiper-prev1");
const prev2 = document.querySelector(".swiper-prev2");
const next1 = document.querySelector(".swiper-next1");
const next2 = document.querySelector(".swiper-next2");

prev1.addEventListener("click", function () {
  document.querySelector(".swiper-wrapper1").style.transform = "translate(0vw)";
});

next1.addEventListener("click", function () {
  document.querySelector(".swiper-wrapper1").style.transform = "translate(-100vw)";
});

prev2.addEventListener("click", function () {
  document.querySelector(".swiper-wrapper2").style.transform = "translate(0vw)";
});

next2.addEventListener("click", function () {
  document.querySelector(".swiper-wrapper2").style.transform = "translate(-100vw)";
});
