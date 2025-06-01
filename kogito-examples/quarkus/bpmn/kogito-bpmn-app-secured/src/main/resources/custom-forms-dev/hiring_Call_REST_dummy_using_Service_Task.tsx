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
const Form__hiring_Call_REST_dummy_using_Service_Task: React.FC<any> = (
	props: any
) => {
	const [formApi, setFormApi] = useState<any>();
	const [Interface, set__Interface] = useState<string>('');
	const [Operation, set__Operation] = useState<string>('');
	const [candidateData__experience, set__candidateData__experience] =
		useState<string>('');
	const [candidateData__fullName, set__candidateData__fullName] =
		useState<string>('');
	const [candidateData__skills, set__candidateData__skills] = useState<
		string[]
	>([]);
	const [implementation, set__implementation] = useState<string>('');
	const [interfaceImplementationRef, set__interfaceImplementationRef] =
		useState<string>('');
	const [operationImplementationRef, set__operationImplementationRef] =
		useState<string>('');
	/* Utility function that fills the form with the data received from the kogito runtime */
	const setFormData = (data) => {
		if (!data) {
			return;
		}
		set__Interface(data?.Interface ?? '');
		set__Operation(data?.Operation ?? '');
		set__candidateData__experience(data?.candidateData?.experience ?? '');
		set__candidateData__fullName(data?.candidateData?.fullName ?? '');
		set__candidateData__skills(data?.candidateData?.skills ?? []);
		set__implementation(data?.implementation ?? '');
		set__interfaceImplementationRef(data?.interfaceImplementationRef ?? '');
		set__operationImplementationRef(data?.operationImplementationRef ?? '');
	};
	/* Utility function to generate the expected form output as a json object */
	const getFormData = useCallback(() => {
		const formData: any = {};
		return formData;
	}, []);
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
				fieldId={'uniforms-000m-0000'}
				label={'Interface'}
				isRequired={false}>
				<TextInput
					name={'Interface'}
					id={'uniforms-000m-0000'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={Interface}
					onChange={set__Interface}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000m-0001'}
				label={'Operation'}
				isRequired={false}>
				<TextInput
					name={'Operation'}
					id={'uniforms-000m-0001'}
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
						<b>Candidate data</b>
					</label>
					<FormGroup
						fieldId={'uniforms-000m-0004'}
						label={'Experience'}
						isRequired={false}>
						<TextInput
							name={'candidateData.experience'}
							id={'uniforms-000m-0004'}
							isDisabled={true}
							placeholder={''}
							type={'text'}
							value={candidateData__experience}
							onChange={set__candidateData__experience}
						/>
					</FormGroup>
					<FormGroup
						fieldId={'uniforms-000m-0005'}
						label={'Full name'}
						isRequired={false}>
						<TextInput
							name={'candidateData.fullName'}
							id={'uniforms-000m-0005'}
							isDisabled={true}
							placeholder={''}
							type={'text'}
							value={candidateData__fullName}
							onChange={set__candidateData__fullName}
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
											set__candidateData__skills(
												(candidateData__skills ?? []).concat([''])
											);
									}}>
									<PlusCircleIcon color='#0088ce' />
								</Button>
							</SplitItem>
						</Split>
						<div>
							{candidateData__skills?.map((_, itemIndex) => (
								<div
									key={itemIndex}
									style={{
										marginBottom: '1rem',
										display: 'flex',
										justifyContent: 'space-between',
									}}>
									<div style={{ width: '100%', marginRight: '10px' }}>
										<FormGroup
											fieldId={'uniforms-000m-0008'}
											label={''}
											isRequired={false}>
											<TextInput
												name={`candidateData__skills.${itemIndex}`}
												id={'uniforms-000m-0008'}
												isDisabled={true}
												placeholder={''}
												type={'text'}
												value={candidateData__skills?.[itemIndex]}
												onChange={(newValue) => {
													set__candidateData__skills((s) => {
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
												const value = [...candidateData__skills];
												value.splice(itemIndex, 1);
												!true && set__candidateData__skills(value);
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
				fieldId={'uniforms-000m-0009'}
				label={'Implementation'}
				isRequired={false}>
				<TextInput
					name={'implementation'}
					id={'uniforms-000m-0009'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={implementation}
					onChange={set__implementation}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000m-000a'}
				label={'Interface implementation ref'}
				isRequired={false}>
				<TextInput
					name={'interfaceImplementationRef'}
					id={'uniforms-000m-000a'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={interfaceImplementationRef}
					onChange={set__interfaceImplementationRef}
				/>
			</FormGroup>
			<FormGroup
				fieldId={'uniforms-000m-000b'}
				label={'Operation implementation ref'}
				isRequired={false}>
				<TextInput
					name={'operationImplementationRef'}
					id={'uniforms-000m-000b'}
					isDisabled={true}
					placeholder={''}
					type={'text'}
					value={operationImplementationRef}
					onChange={set__operationImplementationRef}
				/>
			</FormGroup>
		</div>
	);
};
export default Form__hiring_Call_REST_dummy_using_Service_Task;
