import React from 'react';
import '../../src';
import { useNavigate} from 'react-router-dom'

function Quarter (){
    let navigate = useNavigate();
    
    function RedirectTo(){
        navigate('/')
    }

    return (
        <div style={{backgroundColor:"#999999", padding: 5,}}>
            <div>
                <button onClick={RedirectTo}>Q!</button> 
                <button onClick={RedirectTo}>Q2</button>
                <button onClick={RedirectTo}>Q3</button> 
                <button onClick={RedirectTo}>Q4</button>
                <button onClick={RedirectTo}>OT</button>  
            </div>

        </div>
    );
}

export default  Quarter;