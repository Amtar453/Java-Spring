document.addEventListener('DOMContentLoaded', function () {
    const editButton = document.getElementById('editButton');
    const saveButton = document.getElementById('saveButton');
    const inputs = document.querySelectorAll('input');

    editButton.addEventListener('click', function () {
        inputs.forEach(function (input) {
            input.readOnly = false;
        });
        saveButton.removeAttribute('disabled');
        editButton.setAttribute('disabled', 'true');
    });
});