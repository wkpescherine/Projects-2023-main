import React, {useState} from 'react';
import '../App.css';
import {useNavigate} from 'react-router-dom'

function CreateAccount(){
    const[newUsername,setNewUsername] = useState ("");
    const[newPassword,setNewPassword] = useState ("");
    const[newEmail, setNewEmail] = useState("")
    const[confirmUsername, setConfirmUsername] = useState("")
    const[confirmPassword, setConfirmPassword] = useState("")

    const handleNewUsernameChange = (event) => {
        setNewUsername(event.target.value)
    }

    const handleNewPasswordChange = (event) => {
        setNewPassword(event.target.value)
    }
    const handleEmailChange = (event) => {
        setNewEmail(event.target.value)
    }
    const handleConfirmUsernameChange = (event) => {
        setConfirmUsername(event.target.value)
    }
    const handleConfirmPasswordChange = (event) => {
        setConfirmPassword(event.target.value)
    }

    let navigate = useNavigate();

    function RedirectTo(page){
        if(page ==="dash"){
            if(newUsername != "" && newPassword!= ""){
                if(newUsername === confirmUsername && newPassword === confirmPassword){
                    //Will add the logic to put these into DB here
                    navigate('/dashboard')   
                }
            }
        }
        if(page === "main"){
            navigate('/')
        }
    }
    return (
        <div>
            <p> 
                Enter New Username 
                <input type="text" placeholder="Enter username" onChange={handleNewUsernameChange}></input>
            </p>
            <p>
                Enter New Password
                <input type="text" placeholder="Enter password" onChange={handleNewPasswordChange}></input>
            </p>
            <p> 
                Enter New Email
                <input type="text" placeholder="Enter emil" onChange={handleEmailChange}></input>
            </p>
            <p>
                Confirm Username
                <input type="text" placeholder="Confirm Username" onChange={handleConfirmUsernameChange}></input>
            </p>
            <p>
                Confirm Username
                <input type="text" placeholder="Confirm Password" onChange={handleConfirmPasswordChange}></input>
            </p>
            <p>
                <button onClick={() => RedirectTo("main")}>Back</button> 
                <button onClick={() => RedirectTo("dash")}>Create</button>
            </p>
        </div>
    );
}

export default CreateAccount;