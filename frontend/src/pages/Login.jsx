import { useState } from "react";
import { useNavigate } from "react-router-dom";

import {
    login,
    getCurrentUser
} from "../Service/authService";

export default function Login() {

    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            const response =
                await login(
                    email,
                    password
                );

            localStorage.setItem(
                "token",
                response.token
            );

            const user =
                await getCurrentUser();

            if (user.role === "ROLE_ADMIN") {
                navigate("/admin");
            }

            else if (user.role === "ROLE_OWNER") {
                navigate("/owner");
            }

            else {
                navigate("/signer");
            }

        } catch (error) {

            console.error(error);

            alert("Invalid Credentials");
        }
    };

    return (
        <div className="container">

            <h2>Login</h2>

            <form onSubmit={handleSubmit}>

                <input
                    type="email"
                    placeholder="Email"
                    onChange={(e) =>
                        setEmail(e.target.value)}
                />

                <input
                    type="password"
                    placeholder="Password"
                    onChange={(e) =>
                        setPassword(e.target.value)}
                />

                <button type="submit">
                    Login
                </button>

            </form>

        </div>
    );
}