// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random movie to the page.
 */
// async function addRandomMovie() {
//     const responseFromServer = await fetch("/movie");
//     const moviesFromResponse = await responseFromServer.json();

//     // Pick a random movie.
//     const movie = moviesFromResponse[Math.floor(Math.random() * Object.keys(moviesFromResponse).length)];

//     // Add it to the page.
//     const movieContainer = document.getElementById('movie-container');
//     console.log(movie);
//     movieContainer.innerText = movie;
// }


/*
* Try fetch /hello server
*/
// async function sayHello(){
//     const responseFromServer = await fetch("/hello");
//     const textFromResponse = await responseFromServer.text();

//     const greeting = document.getElementById("hello");
//     greeting.innerText = textFromResponse;
// }


// scroll up functionality
function ScrollUpClicked() {
    const scrollUp = document.getElementById("scroll-up");

    window.scrollTo({
        top: 0,
        left: 0,
        behavior: "smooth",
    });
}


// Navbar Menu 
function menuToggled() {
    const menu = document.getElementById("menu");
    const ul = document.querySelector("nav ul");
    const nav = document.querySelector("nav");

    ul.classList.toggle("show");

    const navLink = document.querySelectorAll(".nav-link");
    navLink.forEach((link) => 
        link.addEventListener("click", ()=> {
            ul.classList.remove("show");
        })
    );
}


