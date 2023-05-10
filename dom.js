// Function to fetch all items and add items in table 
function viewAllItems() {
    fetch('http://localhost:8080/items/viewAll')
      .then(response => response.json())
      .then(items => {
        console.log(items);
        const tableBody = document.querySelector('tbody');
        tableBody.innerHTML = '';
  
        items.forEach(item => {
          const row = document.createElement('tr');
          row.innerHTML = `
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.description}</td>
          `;
          tableBody.appendChild(row);
        });
      })
      .catch(error => console.log(error));
  }
  
  // Function to search for items based on keyword
  function searchItems(keyword) {
    if(keyword===""){
      const tableBody = document.querySelector('tbody');
        tableBody.innerHTML = '';
        return;
    }
    fetch(`http://localhost:8080/items?keyword=${keyword}`)
      .then(response => response.json())
      .then(items => {
        const tableBody = document.querySelector('tbody');
        tableBody.innerHTML = '';
  
        items.forEach(item => {
          const row = document.createElement('tr');
          row.innerHTML = `
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.description}</td>
          `;
          tableBody.appendChild(row);
        });
      })
      .catch(error => console.log(error));
  }
  
  // Function to add a new item
  function addItem(name, description) {
    const newItem = { name, description };
  
    fetch('http://localhost:8080/items/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newItem)
    })
      .then(response => response.text())
      .then(result => {
        console.log(result);
        // Perform any necessary actions after adding an item
      })
      .catch(error => console.log(error));
  }
  
  // Event listeners
  document.getElementById('viewall').addEventListener('click', viewAllItems);
  
  document.getElementById('search').addEventListener('click', () => {
    const keyword = document.getElementById('Searchbox').value;
    searchItems(keyword);
  });
  
  document.getElementById('add').addEventListener('click', () => {
    const name = document.getElementById('name').value;
    const description = document.getElementById('description').value;
    document.getElementById('name').value="";
    document.getElementById('description').value=""
    addItem(name, description);
  });
  