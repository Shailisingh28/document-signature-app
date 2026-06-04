import { useEffect } from "react";
import axios from "axios";

function App() {

  useEffect(() => {
    axios.get("http://localhost:8080/api/test")
      .then(res => console.log(res.data));
  }, []);

  return (
    <h1>Document Signature App</h1>
  );
}

export default App;