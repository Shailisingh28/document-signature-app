import { useState } from "react";
import api from "../api/axios";

export default function Register() {

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: "",
        role: "SIGNER"
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            await api.post(
                "/api/auth/register",
                formData
            );

            alert("Registration Successful");

        } catch (error) {

            console.error(error);

            alert("Registration Failed");
        }
    };

    return (
        <div className="container">
            <h2>Register</h2>

            <form onSubmit={handleSubmit}>

                <input
                    name="name"
                    placeholder="Name"
                    onChange={handleChange}
                />

                <input
                    name="email"
                    placeholder="Email"
                    onChange={handleChange}
                />

                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    onChange={handleChange}
                />

                <select
                    name="role"
                    onChange={handleChange}
                >
                    <option value="SIGNER">Signer</option>
                    <option value="OWNER">Owner</option>
                </select>

                <button type="submit">
                    Register
                </button>

            </form>
        </div>
    );
}