import { useEffect } from "react";
import axios from "axios";

function App() {

  useEffect(() => {
    axios.post("http://localhost:8080/api/auth/login", {
      email: "papa@gmail.com",
      password: "papa123"
    })
    .then(loginRes => {
      console.log("LOGIN RESPONSE:", loginRes.data);

      const token = loginRes.data.token;
      console.log("TOKEN:", token);

      return axios.get(
        "http://localhost:8080/api/user/me",
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );
    })
    .then(userRes => {
      console.log("USER RESPONSE:", userRes.data);
    })
    .catch(err => {
      console.log("STATUS:", err.response?.status);
      console.log("DATA:", err.response?.data);
      console.log(err);
    });
  }, []);

  return (
    <h1>Document Signature App</h1>
  );
}

export default App;