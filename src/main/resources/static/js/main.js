const commentModal = document.querySelector('.comment-modal')
const commentOverlay = document.querySelector('.overlay')
const commentForm = document.querySelector('.comment-modal-form')
const openModalBtn = document.querySelector('.open-modal-btn')
commentForm.addEventListener('submit', () => {
    commentModal.classList.toggle('hidden');
})

commentOverlay.addEventListener('click', e => {
    commentModal.classList.toggle('hidden');
})

openModalBtn.addEventListener('click', () => {
    commentModal.classList.toggle('hidden');
})