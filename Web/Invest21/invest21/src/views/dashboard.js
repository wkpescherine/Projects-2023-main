import React, {useState} from 'react';
import '../App.css';
import {useNavigate} from 'react-router-dom'

import Search from "../components/search"

function Dashboard(){
    const [section, setSection] = useState("home")
    let navigate = useNavigate();

    function RedirectTo(page){
        if(page ==="home"){
            setSection("home")
            navigate('/dashboard')
        }
        if(page === "search"){
            setSection("search")
            navigate('/dashboard/search')
        }
        if(page === "profile"){
            setSection("profile")
            navigate('/dashboard/profile')
        }
        if(page === "logout"){
            navigate('/')
        }
    }
    return (
        <div>
            <button onClick={() => RedirectTo("home")}>Home</button>
            <button onClick={() => RedirectTo("search")}>Search</button>
            <button onClick={() => RedirectTo("profile")}>Profile</button>
            <button onClick={() => RedirectTo("logout")}>Logout</button>
            {section ==="home" &&
                <p>Home Section</p>
            }
            {section ==="search" &&
                <Search />
            }
            {section ==="profile" &&
                <p>Profile Section</p>
            }
        </div>
    );
}

export default Dashboard;