import { useState } from "react";
import { createSignature } from "../Service/signatureService";

export default function SignaturePlacement() {

    const [coordinates, setCoordinates] =
        useState(null);

    const handleClick = (e) => {

        const rect =
            e.currentTarget.getBoundingClientRect();

        const x =
            e.clientX - rect.left;

        const y =
            e.clientY - rect.top;

        setCoordinates({
            x,
            y
        });
    };

    const saveSignature = async () => {

        if (!coordinates) {
            alert("Please select a position first");
            return;
        }

        try {

            await createSignature({
                documentId: 1,
                signerId: 9,
                pageNumber: 1,
                xCoordinate: coordinates.x,
                yCoordinate: coordinates.y
            });

            alert("Signature Position Saved");

        } catch (error) {

            console.error(error);

            alert("Failed to save signature position");
        }
    };

    return (
        <div>

            <h2>
                Select Signature Position
            </h2>

            <div
                onClick={handleClick}
                style={{
                    width: "700px",
                    height: "900px",
                    border: "1px solid black",
                    cursor: "crosshair"
                }}
            >
                PDF Preview Area
            </div>

            {
                coordinates &&
                (
                    <>
                        <p>
                            X: {coordinates.x}
                            {" "}
                            Y: {coordinates.y}
                        </p>

                        <button
                            onClick={saveSignature}
                        >
                            Save Signature Position
                        </button>
                    </>
                )
            }

        </div>
    );
}