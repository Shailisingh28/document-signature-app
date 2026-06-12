import { useState } from "react";

import {
    uploadDocument
} from "../Service/documentService";

export default function UploadDocument() {

    const [file, setFile] =
        useState(null);

    const handleUpload =
        async () => {

            try {

                await uploadDocument(file);

                alert(
                    "Upload Successful"
                );

            } catch (error) {

                console.error(error);

                alert(
                    "Upload Failed"
                );
            }
        };

    return (
        <div className="container">

            <h2>
                Upload PDF
            </h2>

            <input
                type="file"
                accept=".pdf"
                onChange={(e) =>
                    setFile(
                        e.target.files[0]
                    )
                }
            />

            <button
                onClick={handleUpload}
            >
                Upload
            </button>

        </div>
    );
}