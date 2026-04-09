// Generic function to display alerts
function showAlert(message, type) {
    const alertBox = document.getElementById("alertBox");
    if (!alertBox) return;

    // Remove old alerts to avoid spam
    alertBox.innerHTML = '';

    const div = document.createElement("div");
    div.className = "alert " + (type === "success" ? "alert-success" : "alert-error");
    div.innerText = message;
    
    alertBox.appendChild(div);
    
    setTimeout(() => {
        div.remove();
    }, 4000);
}

// Function to format ISO Datetime
function formatDateTime(isoString) {
    if (!isoString) return "";
    const date = new Date(isoString.replace(' ', 'T'));
    const options = { day: '2-digit', month: 'short', year: 'numeric', hour: '2-digit', minute: '2-digit' };
    return date.toLocaleDateString('en-GB', options);
}

// Validation for login
function validateLoginForm() {
    const user = document.getElementById("username").value.trim();
    const pass = document.getElementById("password").value.trim();
    const errorCont = document.getElementById("loginError");
    
    if (user === "" || pass === "") {
        errorCont.innerText = "Username and password cannot be empty.";
        return false;
    }
    errorCont.innerText = "";
    return true;
}

// Validation for member
function validateMemberForm() {
    let isValid = true;
    
    const name = document.getElementById("name").value.trim();
    const nameErr = document.getElementById("nameErr");
    if (name.length < 2) { nameErr.innerText = "Name is required (min 2 chars)."; isValid = false; }
    else { nameErr.innerText = ""; }
    
    const phone = document.getElementById("phone").value.trim();
    const phoneErr = document.getElementById("phoneErr");
    if (!/^[0-9]{10}$/.test(phone)) { phoneErr.innerText = "Valid 10-digit phone required."; isValid = false; }
    else { phoneErr.innerText = ""; }
    
    const weight = document.getElementById("weight").value.trim();
    const weightErr = document.getElementById("weightErr");
    if (isNaN(weight) || parseFloat(weight) <= 0) { weightErr.innerText = "Must be a positive number."; isValid = false; }
    else { weightErr.innerText = ""; }
    
    const gender = document.getElementById("gender").value;
    const genderErr = document.getElementById("genderErr");
    if (gender === "") { genderErr.innerText = "Please select gender."; isValid = false; }
    else { genderErr.innerText = ""; }
    
    const joinDate = document.getElementById("joinDate").value;
    const joinErr = document.getElementById("joinErr");
    if (joinDate === "") { joinErr.innerText = "Join date required."; isValid = false; }
    else { joinErr.innerText = ""; }
    
    return isValid;
}

// Validation for trainer
function validateTrainerForm() {
    let isValid = true;
    
    const name = document.getElementById("name").value.trim();
    const nameErr = document.getElementById("nameErr");
    if (name === "") { nameErr.innerText = "Name required."; isValid = false; }
    else { nameErr.innerText = ""; }
    
    const phone = document.getElementById("phone").value.trim();
    const phoneErr = document.getElementById("phoneErr");
    if (!/^[0-9]{10}$/.test(phone)) { phoneErr.innerText = "Valid 10-digit phone required."; isValid = false; }
    else { phoneErr.innerText = ""; }
    
    const spec = document.getElementById("specialization").value.trim();
    const specErr = document.getElementById("specErr");
    if (spec === "") { specErr.innerText = "Specialization required."; isValid = false; }
    else { specErr.innerText = ""; }

    return isValid;
}

// Generic dropdown populator
function populateDropdown(selectId, url, valueField, textField, defaultOption) {
    const select = document.getElementById(selectId);
    if (!select) return;
    
    select.innerHTML = '<option value="">' + defaultOption + '</option>';
    
    fetch(url)
    .then(r => r.json())
    .then(data => {
        if (Array.isArray(data)) {
            data.forEach(item => {
                const opt = document.createElement("option");
                opt.value = item[valueField];
                opt.text = item[textField];
                select.appendChild(opt);
            });
        }
    })
    .catch(console.error);
}
