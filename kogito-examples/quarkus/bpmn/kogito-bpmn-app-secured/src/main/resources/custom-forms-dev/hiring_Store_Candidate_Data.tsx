import React, { useCallback, useEffect, useState } from 'react';
import {
	TextInput,
	FormGroup,
	Card,
	CardBody,
	Split,
	SplitItem,
	Button,
} from '@patternfly/react-core';
import { PlusCircleIcon, MinusCircleIcon } from '@patternfly/react-icons';
const Form__hiring_Store_Candidate_Data: React.FC<any> = (props: any) => {
	const [formApi, setFormApi] = useState<any>();
	const [Interface, set__Interface] = useState<string>('');
	const [Operation, set__Operation] = useState<string>('');
	const [
		candidateDataRestDTO__experience,
		set__candidateDataRestDTO__experience,
	] = useState<string>('');
	const [candidateDataRestDTO__fullName, set__candidateDataRestDTO__fullName] =
		useState<string>('');
	const [candidateDataRestDTO__skills, set__candidateDataRestDTO__skills] =
		useState<string[]>([]);
	const [implementation, set__implementation] = useState<string>('');
	const [interfaceImplementationRef, set__interfaceImplementationRef] =
		useState<string>('');
	const [operationImplementationRef, set__operationImplementationRef] =
		useState<string>('');
	const [Result, set__Result] = useState<string>('');
	/* Utility function that fills the form with the data received from the kogito runtime */
	const setFormData = (data) => {
		if (!data) {
			return;
		}
		set__Interface(data?.Interface ?? '');
		set__Operation(data?.Operation ?? '');
		set__candidateDataRestDTO__experience(
			data?.candidateDataRestDTO?.experience ?? ''
		);
		set__candidateDataRestDTO__fullName(
			data?.candidateDataRestDTO?.fullName ?? ''
		);
		set__candidateDataRestDTO__skills(data?.candidateDataRestDTO?.skills ?? []);
		set__implementation(data?.implementation ?? '');
		set__interfaceImplementationRef(data?.interfaceImplementationRef ?? '');
		set__operationImplementationRef(data?.operationImplementationRef ?? '');
		set__Result(data?.Result ?? '');
	};
	/* Utility function to generate the expected form output as a json object */
	const getFormData = useCallback(() => {
		const formData: any = {};
		formData.Result = Result;
		return formData;
	}, [Result]);
	/* Utility function to validate the form on the 'beforeSubmit' Lifecycle Hook */
	const validateForm = useCallback(() => {}, []);
	/* Utility function to perform actions on the on the 'afterSubmit' Lifecycle Hook */
	const afterSubmit = useCallback((result) => {}, []);
	useEffect(() => {
		if (formApi) {
			/*
        Form Lifecycle Hook that will be executed before the form is submitted.
        Throwing an error will stop the form submit. Usually should be used to validate the form.
      */
			formApi.beforeSubmit = () => validateForm();
			/*
        Form Lifecycle Hook that will be executed after the form is submitted.
        It will receive a response object containing the `type` flag indicating if the submit has been successful and `info` with extra information about the submit result.
      */
			formApi.afterSubmit = (result) => afterSubmit(result);
			/* Generates the expected form output object to be posted */
			formApi.getFormData = () => getFormData();
		}
	}, [getFormData, validateForm, afterSubmit]);
	useEffect(() => {
		/*
      Call to the Kogito console form engine. It will establish the connection with the console embeding the form
      and return an instance of FormAPI that will allow hook custom code into the form lifecycle.
      The `window.Form.openForm` call expects an object with the following entries:
        - onOpen: Callback that will be called after the connection with the console is established. The callback
        will receive the following arguments:
          - data: the data to be bound into the form
          - ctx: info about the context where the form is being displayed. This will contain information such as the form JSON Schema, process/task, user...
    */
		const api = window.Form.openForm({
			onOpen: (data, context) => {
				setFormData(data);
			},
		});
		setFormApi(api);
	}, []);
	return (
		<div className={'pf-c-form'}>
			<FormGroup
				fieldId={'uniforms-000w-0000'}
				label={'Interface'}
				isRequired={false}>
				<TextInput
					name={'Interface'}
					id={'uniforms-000w-0000'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={Interface}
					onChange={set__Interface}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000w-0001'}
				label={'Operation'}
				isRequired={false}>
				<TextInput
					name={'Operation'}
					id={'uniforms-000w-0001'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={Operation}
					onChange={set__Operation}
				/>
			</FormGroup>
			<Card>
				<CardBody className='pf-c-form'>
					<label>
						<b>Candidate data rest dto</b>
					</label>
					<FormGroup
						fieldId={'uniforms-000w-0004'}
						label={'Experience'}
						isRequired={false}>
						<TextInput
							name={'candidateDataRestDTO.experience'}
							id={'uniforms-000w-0004'}
							isDisabled={true}
							placeholder={''}
							type={'text'}
							value={candidateDataRestDTO__experience}
							onChange={set__candidateDataRestDTO__experience}
						/>
					</FormGroup>
					<FormGroup
						fieldId={'uniforms-000w-0005'}
						label={'Full name'}
						isRequired={false}>
						<TextInput
							name={'candidateDataRestDTO.fullName'}
							id={'uniforms-000w-0005'}
							isDisabled={true}
							placeholder={''}
							type={'text'}
							value={candidateDataRestDTO__fullName}
							onChange={set__candidateDataRestDTO__fullName}
						/>
					</FormGroup>
					<div>
						<Split hasGutter>
							<SplitItem>
								{'Skills' && (
									<label className={'pf-c-form__label'}>
										<span className={'pf-c-form__label-text'}>Skills</span>
									</label>
								)}
							</SplitItem>
							<SplitItem isFilled />
							<SplitItem>
								<Button
									name='$'
									variant='plain'
									style={{ paddingLeft: '0', paddingRight: '0' }}
									disabled={true}
									onClick={() => {
										!true &&
											set__candidateDataRestDTO__skills(
												(candidateDataRestDTO__skills ?? []).concat([''])
											);
									}}>
									<PlusCircleIcon color='#0088ce' />
								</Button>
							</SplitItem>
						</Split>
						<div>
							{candidateDataRestDTO__skills?.map((_, itemIndex) => (
								<div
									key={itemIndex}
									style={{
										marginBottom: '1rem',
										display: 'flex',
										justifyContent: 'space-between',
									}}>
									<div style={{ width: '100%', marginRight: '10px' }}>
										<FormGroup
											fieldId={'uniforms-000w-0008'}
											label={''}
											isRequired={false}>
											<TextInput
												name={`candidateDataRestDTO__skills.${itemIndex}`}
												id={'uniforms-000w-0008'}
												isDisabled={true}
												placeholder={''}
												type={'text'}
												value={candidateDataRestDTO__skills?.[itemIndex]}
												onChange={(newValue) => {
													set__candidateDataRestDTO__skills((s) => {
														const newState = [...s];
														newState[itemIndex] = newValue;
														return newState;
													});
												}}
											/>
										</FormGroup>
									</div>
									<div>
										<Button
											disabled={true}
											variant='plain'
											style={{ paddingLeft: '0', paddingRight: '0' }}
											onClick={() => {
												const value = [...candidateDataRestDTO__skills];
												value.splice(itemIndex, 1);
												!true && set__candidateDataRestDTO__skills(value);
											}}>
											<MinusCircleIcon color='#cc0000' />
										</Button>
									</div>
								</div>
							))}
						</div>
					</div>
				</CardBody>
			</Card>
			<FormGroup
				fieldId={'uniforms-000w-0009'}
				label={'Implementation'}
				isRequired={false}>
				<TextInput
					name={'implementation'}
					id={'uniforms-000w-0009'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={implementation}
					onChange={set__implementation}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000w-000a'}
				label={'Interface implementation ref'}
				isRequired={false}>
				<TextInput
					name={'interfaceImplementationRef'}
					id={'uniforms-000w-000a'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={interfaceImplementationRef}
					onChange={set__interfaceImplementationRef}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000w-000b'}
				label={'Operation implementation ref'}
				isRequired={false}>
				<TextInput
					name={'operationImplementationRef'}
					id={'uniforms-000w-000b'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={operationImplementationRef}
					onChange={set__operationImplementationRef}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000w-000c'}
				label={'Result'}
				isRequired={false}>
				<TextInput
					name={'Result'}
					id={'uniforms-000w-000c'}
					isDisabled={false}
					placeholder={''}
					type={'text'}
					value={Result}
					onChange={set__Result}
				/>
			</FormGroup>
		</div>
	);
};
export default Form__hiring_Store_Candidate_Data;
