import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md ">
                        <br></br>
                    <div > <a href="/users" className="navbar-brand">Projet(CRUD)USERS</a></div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent
