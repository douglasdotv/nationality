document.getElementById('sortButton').addEventListener('click', function() {
    const list = document.getElementById('playersList');
    const items = Array.from(list.getElementsByClassName('list-group-item'));
    let sorted = false;

    items.sort(function(a, b) {
        let valA = parseInt(a.querySelector('.badge').textContent);
        let valB = parseInt(b.querySelector('.badge').textContent);

        if (list.classList.contains('sorted')) {
            return valB - valA;
        } else {
            return valA - valB;
        }
    }).forEach(item => {
        list.appendChild(item);
    });

    list.classList.toggle('sorted');
});
