import { useState, useEffect } from "react"
import Profile from "./Profile"

const UserProfiles = () => {
    let [profiles, setProfiles] = useState([])

    const fetchUserProfiles = async () => {
        try {
            let response = await fetch("http://localhost:8080/api/v1/user-profile")
            let data = await response.json()
            //console.log(data)
            setProfiles(() => data)
        } catch (e) {
            console.error(e)
        }
    }

    useEffect(() => {
        fetchUserProfiles()
    }, [])

    return profiles.map((profile, index) => {
        return (
            <Profile key={index} {...profile}></Profile>          
        )
    })
}

export default UserProfiles