import React, {useCallback, useEffect} from 'react'
import {useDropzone} from 'react-dropzone'

function Dropzone({ userProfileId }) {
    const onDrop = useCallback(acceptedFiles => {
      // Do something with the files
      const file = acceptedFiles[0]
      console.log(acceptedFiles)
      let url = `http://localhost:8080/api/v1/user-profile/${userProfileId}/image/upload`
      const formData = new FormData()
      formData.append("file", file)
      let options = {
        method: 'POST',
        mode: 'no-cors',
        body: formData
      }
      const request = new Request(url, options)
      console.log(request)
      fetch(request).then(() => console.log("file uploaded")).catch((e) => console.error(e))
    }, [])
    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})
  
    return (
      <div {...getRootProps()}>
        <input {...getInputProps()} />
        {
          isDragActive ?
            <p>Drop the files here ...</p> :
            <p>Drag 'n' drop some files here, or click to select files</p>
        }
      </div>
    )
}

const Profile = (profile) => {

    useEffect(async () => {
      profile.userProfileImageLink = await fetch(`http://localhost:8080/api/v1/user-profile/${profile.userProfileId}/image/download`)
    }, [])

    return (
        <div className='Profile'>
            <h1>{profile.username}</h1>
            { (profile.userProfileImageLink !== null) ? <img width={200} height={200} src={`http://localhost:8080/api/v1/user-profile/${profile.userProfileId}/image/download`}></img> : <br/> }
            <div>
                <Dropzone {...profile}/>
            </div>
        </div>
    )
}

export default Profile