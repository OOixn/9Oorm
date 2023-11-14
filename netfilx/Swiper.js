const swiper1 = new Swiper(".swiper-container1", {
  slidesPerView: 4,
  spaceBetween: 30,
  loop: true,
  navigation: {
    nextEl: ".swiper-next1",
    prevEl: ".swiper-prev1",
  },
});

const swiper2 = new Swiper(".swiper-container2", {
  slidesPerView: 4,
  spaceBetween: 30,
  loop: true,
  navigation: {
    nextEl: ".swiper-next2",
    prevEl: ".swiper-prev2",
  },
});

const headerBg = document.querySelector(".main_header");

window.addEventListener("scroll", function () {
  if (window.scrollY >= 200) {
    headerBg.style.backgroundColor = "#111";
  } else {
    headerBg.style.backgroundColor = "transparent";
  }
});
