import React from 'react';
import Image from './team.png'

console.log(Image);

function Header(){
    return (
        <div className="HeaderForm">
            <header className="HeaderForm-Header">
                <img src={Image} alt="Image" width="80" height="120" class="center"/>
                    <label>
                        Consultar empleados
                 </label>
            </header>
        </div>

    );
}

export default Header;