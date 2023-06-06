import React, {useState} from 'react';
import '../App.css';
import {useNavigate} from 'react-router-dom'

function Main() {
    const[logInUsername,setLogInUsername] = useState ("");
    const[logInPassword,setLogInPassword] = useState ("");

    let navigate = useNavigate();
    
    const handleLogInUsernameChange = (event) => {
        setLogInUsername(event.target.value)
    }

    const handleLogInPasswordChange = (event) => {
        setLogInPassword(event.target.value)
    }
    
    function RedirectTo(page){
        if(page ==="dash"){
            console.log(logInUsername)
            console.log(logInPassword)
            navigate('./dashboard')
        }
        if(page === "create"){
            navigate('./createaccount')
        }
    }

    return (
        <div>
            <p>
                <input type="text" placeholder="Enter username" onChange={handleLogInUsernameChange}></input>
            </p>
            <p>
                <input type="text" placeholder="Enter password" onChange={handleLogInPasswordChange}></input>
            </p>
            <p>
                <button onClick={() => RedirectTo("dash")}>Login</button> 
                <button onClick={() => RedirectTo("create")}>Create Account</button>
            </p>
        </div>
    );
}

export default Main;