import { useEffect, useState }
from "react";

import {
    getDocuments
} from "../Service/documentService";

export default function Documents() {

    const [documents,
        setDocuments] =
        useState([]);

    useEffect(() => {

        fetchDocuments();

    }, []);

    const fetchDocuments =
        async () => {

            const data =
                await getDocuments();

            setDocuments(data);
        };

    return (

        <div className="container">

            <h2>
                My Documents
            </h2>

            {
                documents.map(
                    doc => (

                        <div key={doc.id}>

                            <p>
                                {doc.fileName}
                            </p>

                            <p>
                                {doc.status}
                            </p>

                        </div>
                    )
                )
            }

        </div>
    );
}