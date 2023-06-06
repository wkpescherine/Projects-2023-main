import React from 'react';
import '../../src';
import { useNavigate} from 'react-router-dom'

function Teams (){
    let navigate = useNavigate();
    
    function RedirectTo(){
        navigate('/')
    }

    return (
        <div className='divBack'>
            <div>
                <button onClick={RedirectTo}>NE</button> 
                <button onClick={RedirectTo}>MIA</button>
                <button onClick={RedirectTo}>NYJ</button> 
                <button onClick={RedirectTo}>BUF</button>  
                <button onClick={RedirectTo}>CLE</button> 
                <button onClick={RedirectTo}>CIN</button>
                <button onClick={RedirectTo}>BAL</button> 
                <button onClick={RedirectTo}>PIT</button>  
                <button onClick={RedirectTo}>KC</button> 
                <button onClick={RedirectTo}>LV</button>
                <button onClick={RedirectTo}>LAC</button> 
                <button onClick={RedirectTo}>DEN</button>  
                <button onClick={RedirectTo}>IND</button> 
                <button onClick={RedirectTo}>JAC</button>
                <button onClick={RedirectTo}>TEN</button> 
                <button onClick={RedirectTo}>HOU</button>  
            </div>
            <div>
                <button onClick={RedirectTo}>DAL</button> 
                <button onClick={RedirectTo}>WAS</button>
                <button onClick={RedirectTo}>PHI</button> 
                <button onClick={RedirectTo}>NYG</button>
                <button onClick={RedirectTo}>NO</button> 
                <button onClick={RedirectTo}>CAR</button>
                <button onClick={RedirectTo}>TB</button> 
                <button onClick={RedirectTo}>ATL</button>  
                <button onClick={RedirectTo}>CHI</button> 
                <button onClick={RedirectTo}>DET</button>
                <button onClick={RedirectTo}>GB</button> 
                <button onClick={RedirectTo}>MIN</button>  
                <button onClick={RedirectTo}>SEA</button> 
                <button onClick={RedirectTo}>LAR</button>
                <button onClick={RedirectTo}>ARI</button> 
                <button onClick={RedirectTo}>SF</button>    
            </div>
        </div>
    );
}

export default  Teams;