import React from 'react';
import '../../src';

function Display (){
    return (
        <div style={{backgroundColor:"#999999", padding: 5,}}>
            <div>
                <p>Home: None Away: None</p>
                <div>
                    <p>Home 0</p>
                    <p>Away 0</p>
                </div>
                <div>
                    <p>1st</p>
                    <p>10</p>
                </div>
                <div>
                  <button>Clear</button>
                  <button>Reset</button>
                </div>
            </div>

        </div>
    );
}

export default  Display;