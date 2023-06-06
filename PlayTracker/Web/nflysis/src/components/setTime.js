import React from 'react';
import '../../src';
import { useNavigate} from 'react-router-dom'

function Teams (){
    let navigate = useNavigate();
    
    function RedirectTo(){
        navigate('/')
    }

    return (
        <div style={{backgroundColor:"#999999", padding: 5,}}>
            <div>
                <button onClick={RedirectTo}>00</button> 
                <button onClick={RedirectTo}>01</button>
                <button onClick={RedirectTo}>02</button> 
                <button onClick={RedirectTo}>03</button>
                <button onClick={RedirectTo}>04</button>  
                <button onClick={RedirectTo}>05</button> 
                <button onClick={RedirectTo}>06</button>
                <button onClick={RedirectTo}>07</button> 
                <button onClick={RedirectTo}>08</button>
                <button onClick={RedirectTo}>09</button>  
                <button onClick={RedirectTo}>10</button> 
                <button onClick={RedirectTo}>11</button>
                <button onClick={RedirectTo}>12</button> 
                <button onClick={RedirectTo}>13</button>
                <button onClick={RedirectTo}>14</button>  
            </div>

        </div>
    );
}

export default  Teams;